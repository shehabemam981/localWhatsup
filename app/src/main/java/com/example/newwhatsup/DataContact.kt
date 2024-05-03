package com.example.newwhatsup

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class DataContact(var name: String, var phone: String, var description: String):Parcelable