package com.kk.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 卡片View项
 *
 * @author xmuSistone
 */
@SuppressLint("NewApi")
public class CardItemView extends LinearLayout {

    private TextView userNameTv;
    private TextView contentTv;
    private ImageView bgIv;

    public CardItemView(Context context) {
        this(context, null);
    }

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate(context, R.layout.card_item, this);
        userNameTv = (TextView) findViewById(R.id.card_user_name);
        contentTv = (TextView) findViewById(R.id.card_content);
        bgIv = (ImageView) findViewById(R.id.bg_iv);
    }

    public void fillData(CardDataItem itemData) {
        userNameTv.setText(itemData.language);
        contentTv.setText(itemData.content);
        bgIv.setImageResource(itemData.imgId);
    }
}
