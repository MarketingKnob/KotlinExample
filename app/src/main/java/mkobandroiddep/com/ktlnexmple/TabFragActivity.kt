package mkobandroiddep.com.ktlnexmple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.FrameLayout
import mkobandroiddep.com.ktlnexmple.fragments.JavaFragment
import mkobandroiddep.com.ktlnexmple.fragments.KotlinFragment
import mkobandroiddep.com.ktlnexmple.fragments.PhpFragment

class TabFragActivity : AppCompatActivity() {

    lateinit var tabLayout:TabLayout
    lateinit var frameLayout: FrameLayout
    lateinit var fragment: Fragment
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_frag)

        tabLayout           =findViewById(R.id.tabLayout)
        frameLayout         =findViewById(R.id.frameLayout)

        fragment            =JavaFragment()
        fragmentManager     =supportFragmentManager
        fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()


        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                when(p0?.position){
                    0->fragment=JavaFragment()
                    1->fragment=KotlinFragment()
                    2->fragment=PhpFragment()

                }

                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(R.id.frameLayout, fragment)
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

        })

    }
}
