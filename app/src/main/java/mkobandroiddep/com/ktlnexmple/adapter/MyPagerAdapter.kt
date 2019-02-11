package mkobandroiddep.com.ktlnexmple.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import mkobandroiddep.com.ktlnexmple.fragments.JavaFragment
import mkobandroiddep.com.ktlnexmple.fragments.KotlinFragment
import mkobandroiddep.com.ktlnexmple.fragments.PhpFragment

    class MyPagerAdapter(fm:FragmentManager,val mContext:Context,var noTab:Int): FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        lateinit var fragment: Fragment
        if (position==0){
            fragment=JavaFragment()
        }else if (position==1){
            fragment=KotlinFragment()
        }else if (position==2){
            fragment=PhpFragment()
        }
        return fragment

    }

    override fun getCount(): Int {
        return noTab
    }

}