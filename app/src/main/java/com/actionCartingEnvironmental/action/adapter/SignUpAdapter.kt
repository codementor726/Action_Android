package com.actionCartingEnvironmental.action.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.actionCartingEnvironmental.action.fragment.LoginDetailFragment
import com.actionCartingEnvironmental.action.fragment.RegisterFragment

class SignUpAdapter(fragmentManager: FragmentManager, private val movies: ArrayList<String>) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return RegisterFragment.newInstance(movies[position])
        else
            return LoginDetailFragment.newInstance(movies[position])
    }

    override fun getCount(): Int {
        return movies.size
    }
}