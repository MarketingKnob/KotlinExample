package mkobandroiddep.com.ktlnexmple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import mkobandroiddep.com.ktlnexmple.adapter.MyPagerAdapter

class TabViewPager : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_view_pager)

        findId()

        tabLayout.addTab(tabLayout.newTab().setText("Java"))
        tabLayout.addTab(tabLayout.newTab().setText("Kotlin"))
        tabLayout.addTab(tabLayout.newTab().setText("Php"))

        val pagerAdapter=MyPagerAdapter(supportFragmentManager,this,tabLayout.tabCount)
        viewPager.adapter=pagerAdapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewPager.currentItem= p0!!.position

            }

        })
    }

    fun findId(){

        tabLayout     =findViewById(R.id.tabLayout)
        viewPager     =findViewById(R.id.viewPager)

    }
}
