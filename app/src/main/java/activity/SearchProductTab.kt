package activity

import Interfaces.Apicall
import Interfaces.OnResponse
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.astuetz.PagerSlidingTabStrip
import com.kodpartner.R
import com.social.ekchat.Interfaces.UniverSelObjct
import fragments.PartLSearch
import fragments.PeopleSearch
import model.GetPartListByOrderIdData
import utils.LocalStorage

class SearchProductTab : AppCompatActivity(), OnResponse<UniverSelObjct?> {
    var tabLayout: PagerSlidingTabStrip? = null
    var iv_back: ImageView? = null
    var peopleSearch: PeopleSearch? = null
    var partLSearch: PartLSearch? = null
    var getPartListByOrderIdData: GetPartListByOrderIdData? = null
    var tvTitle: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutus_tab_fragment)
        viewPager =
            findViewById<View>(R.id.viewpager) as ViewPager
        iv_back = findViewById<View>(R.id.iv_back) as ImageView
        tvTitle = findViewById<View>(R.id.tvTitle) as TextView
        tabLayout = findViewById<View>(R.id.tabs) as PagerSlidingTabStrip
        //viewPager!!.adapter = MyAdapter(supportFragmentManager)
        viewPager!!.offscreenPageLimit = 1 // no of fragments
        tvTitle!!.text = "Labour List"
        tabLayout!!.setViewPager(viewPager)

        //Apicall(this).getServiceListForRate(this,"get-rate-card-by-order-id", LocalStorage.getCustomerID(this))
        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        tabLayout!!.post {
            //tabLayout.setupWithViewPager(viewPager);
            tabLayout!!.setOnPageChangeListener(object : OnPageChangeListener {
                // This method will be invoked when a new page becomes selected.
                override fun onPageSelected(position: Int) {
                    //   Toast.makeText(getApplicationContext(), "onPageSelected", Toast.LENGTH_SHORT).show();
                }

                // This method will be invoked when the current page is scrolled
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    // Code goes here
                    //Toast.makeText(getApplicationContext(), "onPageScrolled", Toast.LENGTH_SHORT).show();
                }

                // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
                override fun onPageScrollStateChanged(state: Int) {
                    // Code goes here
                    //Toast.makeText(getApplicationContext(), "onPageScrollStateChanged", Toast.LENGTH_SHORT).show();
                }
            })
        }
        iv_back!!.setOnClickListener { finish() }
    }

    /*override fun onSucess(response: UniverSelObjct) {
        when (response.methodname) {
            "get-rate-card-by-order-id" -> {
                getPartListByOrderIdData = response.response as GetPartListByOrderIdData
                Log.e("get-part-order-id", " " + getPartListByOrderIdData!!.message)
                peopleSearch!!.updateAdapter(getPartListByOrderIdData)
                partLSearch!!.updateAdapter(getPartListByOrderIdData)
            }
        }
    }*/

    override fun onError(error: String) {}

    /*internal inner class MyAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItemPosition(`object`: Any): Int {
            return PagerAdapter.POSITION_NONE
        }

        *//**
         * Return fragment with respect to Position .
         *//*
        *//*override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    peopleSearch = PeopleSearch()
                    return peopleSearch!!
                }
                1 -> {
                    partLSearch = PartLSearch()
                    return partLSearch!!
                }
            }
            return null
        }*//*

        override fun getCount(): Int {
            return int_items
        }

        *//**
         * This method returns the title of the tab according to the position.
         *//*
        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Labour"
                1 -> return "Part-Labour"
            }
            return null
        }
    }*/

    companion object {
        var viewPager: ViewPager? = null
        var int_items = 2
    }

    override fun onSucess(response: UniverSelObjct?) {
        when (response!!.methodname) {
            "get-rate-card-by-order-id" -> {
                getPartListByOrderIdData = response.response as GetPartListByOrderIdData
                Log.e("get-part-order-id", " " + getPartListByOrderIdData!!.message)
                peopleSearch!!.updateAdapter(getPartListByOrderIdData)
                partLSearch!!.updateAdapter(getPartListByOrderIdData)
            }
        }
    }
}