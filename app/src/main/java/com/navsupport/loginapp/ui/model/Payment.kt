package com.navsupport.loginapp.ui.model

import android.os.Parcelable
import android.view.ViewDebug
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Payment(
    @DrawableRes val imageResId:Int,
    @StringRes val TextId:Int
): Parcelable
