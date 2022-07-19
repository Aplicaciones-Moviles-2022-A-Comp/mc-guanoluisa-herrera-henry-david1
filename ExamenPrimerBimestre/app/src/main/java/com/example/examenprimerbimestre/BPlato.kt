package com.example.examenprimerbimestre

import android.os.Parcel
import android.os.Parcelable

class BPlato(
    var nombre: String?,
    var precio: Double?,
    var region: String?,
    var provincia: String?,
    var descripcion: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }
    override fun toString(): String {
        return " ${nombre}\n Precio: ${precio}\n Region: $region \n" +
                " Provincia: $provincia \n Descripcion: ${descripcion} %"
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeValue(precio)
        parcel.writeString(region)
        parcel.writeString(provincia)
        parcel.writeString(descripcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BPlato> {
        override fun createFromParcel(parcel: Parcel): BPlato {
            return BPlato(parcel)
        }

        override fun newArray(size: Int): Array<BPlato?> {
            return arrayOfNulls(size)
        }
    }


}