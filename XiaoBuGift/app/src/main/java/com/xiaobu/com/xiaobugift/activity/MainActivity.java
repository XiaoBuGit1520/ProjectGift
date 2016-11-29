package com.xiaobu.com.xiaobugift.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.fragment.category.CategoryFragment;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftFragment;
import com.xiaobu.com.xiaobugift.fragment.home.HomeFragment;
import com.xiaobu.com.xiaobugift.fragment.profile.ProfileFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton rbtHome, rbtGift, rbtCategory, rbtProfile;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        rbtHome = (RadioButton) findViewById(R.id.rbt_home);
        rbtGift = (RadioButton) findViewById(R.id.rbt_gift);
        rbtCategory = (RadioButton) findViewById(R.id.rbt_category);
        rbtProfile = (RadioButton) findViewById(R.id.rbt_profile);

    }

    @Override
    public void initData() {

        rbtHome.setOnClickListener(this);
        rbtGift.setOnClickListener(this);
        rbtCategory.setOnClickListener(this);
        rbtProfile.setOnClickListener(this);

        // 进入时默认显示HomeFragment
        replaceFragment(R.id.fl, new HomeFragment());
        // 让rbtHome的按钮始终保持按下
        rbtHome.setChecked(true);
    }


    @Override
    public void onClick(View v) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        switch (v.getId()) {

            case R.id.rbt_home:

                transaction.replace(R.id.fl, new HomeFragment());

                break;

            case R.id.rbt_gift:

                transaction.replace(R.id.fl, new GiftFragment());

                break;

            case R.id.rbt_category:

                transaction.replace(R.id.fl, new CategoryFragment());

                break;

            case R.id.rbt_profile:

                transaction.replace(R.id.fl, new ProfileFragment());

                break;
        }
        // 千万不要忘记提交业务
        transaction.commit();
    }

    /**
     * 代码优化
     *
     * @param replace
     * @param fragment
     */
    private void replaceFragment(int replace, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(replace, fragment);
        transaction.commit();

    }


}
