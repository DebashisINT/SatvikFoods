package com.satvikfoods.features.notification

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.satvikfoods.R
import com.satvikfoods.app.AppDatabase
import com.satvikfoods.app.NetworkConstant
import com.satvikfoods.app.Pref
import com.satvikfoods.app.types.FragType
import com.satvikfoods.app.utils.AppUtils
import com.satvikfoods.base.presentation.BaseActivity
import com.satvikfoods.base.presentation.BaseFragment
import com.satvikfoods.features.dashboard.presentation.DashboardActivity
import com.satvikfoods.features.login.presentation.LoginActivity
import com.satvikfoods.features.notification.api.NotificationListRepoProvider
import com.satvikfoods.features.notification.model.NotificationListDataModel
import com.satvikfoods.features.notification.model.NotificationListResponseModel
import com.satvikfoods.mappackage.SendBrod
import com.satvikfoods.widgets.AppCustomTextView
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Saikat on 25-02-2019.
 */
class NotificationFragment : BaseFragment() {

    private lateinit var mContext: Context
    private lateinit var rv_order_list: RecyclerView
    private lateinit var no_shop_tv: AppCustomTextView
    private lateinit var progress_wheel: ProgressWheel
    private lateinit var rl_main: RelativeLayout

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_new_order_list, container, false)

        initView(view)
        getNotificationList()

        return view
    }

    private fun initView(view: View) {

        (mContext as DashboardActivity).logo.clearAnimation()
        (mContext as DashboardActivity).logo.animate().cancel()

        /*val params = (mContext as DashboardActivity).iv_home_icon.layoutParams as RelativeLayout.LayoutParams
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        //params.addRule(RelativeLayout.LEFT_OF, R.id.id_to_be_left_of)
        params.setMargins(0, 0, (mContext as DashboardActivity).resources.getDimensionPixelOffset(R.dimen._10sdp), 0)
        (mContext as DashboardActivity).iv_home_icon.layoutParams = params*/


        rv_order_list = view.findViewById(R.id.rv_order_list)
        rv_order_list.layoutManager = LinearLayoutManager(mContext)
        no_shop_tv = view.findViewById(R.id.no_shop_tv)
        progress_wheel = view.findViewById(R.id.progress_wheel)
        progress_wheel.stopSpinning()
        rl_main = view.findViewById(R.id.rl_main)
       // rl_main.setBackgroundColor(mContext.resources.getColor(android.R.color.white))
        rl_main.setOnClickListener(null)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun getNotificationList() {
        if (!AppUtils.isOnline(mContext)) {
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_internet))
            return
        }

        val repository = NotificationListRepoProvider.notificationListRepository()
        progress_wheel.spin()
        BaseActivity.compositeDisposable.add(
                repository.notificationList(Pref.session_token!!, Pref.user_id!!)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            val response = result as NotificationListResponseModel
                            if (response.status == NetworkConstant.SUCCESS) {

                                progress_wheel.stopSpinning()

                                if (response.notification_list == null || response.notification_list?.size!! == 0) {
                                    //no_shop_tv.visibility = View.VISIBLE
                                    //(mContext as DashboardActivity).showSnackMessage(response.message!!)
                                    initAdapter(response.notification_list)
                                } else
                                    initAdapter(response.notification_list)

                            } else if (response.status == NetworkConstant.SESSION_MISMATCH) {
                                progress_wheel.stopSpinning()
                                (mContext as DashboardActivity).clearData()
                                startActivity(Intent(mContext as DashboardActivity, LoginActivity::class.java))
                                (mContext as DashboardActivity).overridePendingTransition(0, 0)
                                (mContext as DashboardActivity).finish()
                            } else {
                                progress_wheel.stopSpinning()
                                no_shop_tv.visibility = View.VISIBLE
                                (mContext as DashboardActivity).showSnackMessage(response.message!!)
                            }
                        }, { error ->
                            error.printStackTrace()
                            progress_wheel.stopSpinning()
                            no_shop_tv.visibility = View.VISIBLE
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                        })
        )
    }

    private fun initAdapter(notification_list: ArrayList<NotificationListDataModel>?) {
        no_shop_tv.visibility = View.GONE
        /*new work*/
        val shopList = AppDatabase.getDBInstance()?.addShopEntryDao()?.all
        var body = ""
        for(i in 0..shopList!!.size-1){
            var dob = ""
            if(shopList[i].dateOfBirth!=null){
                dob = shopList[i].dateOfBirth.split("T").get(0)
            }
            var anni = ""
            if(shopList[i].dateOfAniversary!=null){
                anni = shopList[i].dateOfAniversary.split("T").get(0)
            }
            var todayDate = AppUtils.getCurrentDateForShopActi()

            var obj : NotificationListDataModel = NotificationListDataModel()

            if (todayDate.equals(dob)){
                body ="Please wish Mr. " + shopList[i].ownerName + " of " + shopList[i].shopName +
                        ", Contact Number: " + shopList[i].ownerContactNumber + " for birthday today."
                obj.phoneNo = shopList[i].ownerContactNumber
            }
            if (todayDate.equals(anni)){
                body = "Please wish Mr. " + shopList[i].ownerName + " of " + shopList[i].shopName+
                        ", Contact Number: " + shopList[i].ownerContactNumber + " for Anniversary today."
                obj.phoneNo = shopList[i].ownerContactNumber
            }


            obj.notificationmessage=body
            obj.id=""
            //obj.date_time=AppUtils.convertToBillingFormat(AppUtils.getCurrentDateTime())+" "+AppUtils.getCurrentTimeWithMeredian()
            obj.date_time=AppUtils.getCurrentDateTime().replace(" ","T")
            body = ""
            if(!obj.notificationmessage.equals(""))
                notification_list!!.add(obj)
        }

        if(notification_list!!.size==0){
            no_shop_tv.visibility = View.VISIBLE
            return
        }

        rv_order_list.adapter = NotificationAdapter(mContext, notification_list, object : NotificationAdapter.OnClickListener {
            override fun onNotificationClick(adapterPosition: Int) {
                if(notification_list?.get(adapterPosition)!!.notificationmessage!!.contains("Please take action on it")){
                    if (!Pref.isAddAttendence)
                        (mContext as DashboardActivity).checkToShowAddAttendanceAlert()
                    else
                        (mContext as DashboardActivity).loadFragment(FragType.LeadFrag, false, "")
                }

            }

            override fun getWhatsappOnLick(phone: String) {
                var phone = "+91" + phone
                sendWhats(phone)
            }
        })
    }

    private fun sendWhats(phone: String) {
        val packageManager: PackageManager = mContext.getPackageManager()
        val i = Intent(Intent.ACTION_VIEW)
        try {
            //val url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode("", "UTF-8")
            val url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + " "
            i.setPackage("com.whatsapp")
            i.data = Uri.parse(url)
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}