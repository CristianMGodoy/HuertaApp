package com.example.huertaapp

import android.os.Parcel
import android.os.Parcelable

data class Cuenta( var IdCuenta : Int,var nombre:String, var numCuenta:Int ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(IdCuenta)
        parcel.writeString(nombre)
        parcel.writeInt(numCuenta)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cuenta> {
        override fun createFromParcel(parcel: Parcel): Cuenta {
            return Cuenta(parcel)
        }

        override fun newArray(size: Int): Array<Cuenta?> {
            return arrayOfNulls(size)
        }
    }
}