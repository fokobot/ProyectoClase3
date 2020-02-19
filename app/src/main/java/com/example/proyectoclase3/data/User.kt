package com.example.proyectoclase3.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val nombre: String, val apellidos: String) : Parcelable{

}