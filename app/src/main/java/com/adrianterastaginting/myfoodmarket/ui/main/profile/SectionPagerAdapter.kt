package com.adrianterastaginting.myfoodmarket.ui.main.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.adrianterastaginting.myfoodmarket.ui.main.home.newtaste.HomeNewTasteFragment
import com.adrianterastaginting.myfoodmarket.ui.main.home.popular.HomePopularFragment
import com.adrianterastaginting.myfoodmarket.ui.main.home.recommended.HomeRecommendedFragment
import com.adrianterastaginting.myfoodmarket.ui.main.profile.account.ProfileAccountFragment
import com.adrianterastaginting.myfoodmarket.ui.main.profile.foodmarket.ProfileFoodMarketFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Account"
            1 -> "FoodMarket"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment
        return when(position) {
            0 -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
            1 -> {
                fragment = ProfileFoodMarketFragment()
                return fragment
            }
            else  -> {
                fragment = ProfileAccountFragment()
                return fragment
            }
        }
    }
}