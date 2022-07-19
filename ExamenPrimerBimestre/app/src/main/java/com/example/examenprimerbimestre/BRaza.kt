package com.example.examenprimerbimestre
import android.os.Parcel
import android.os.Parcelable

class BRaza(
    var nombreRaza: String?,
    var nombreCientífico: String?,
    var alimentacion: String?,
    var maximaEsperanzaVida: Int?,
    var domesticado: Boolean?,
    var nombreEspecie: String?
    ): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreRaza)
        parcel.writeString(nombreCientífico)
        parcel.writeString(alimentacion)
        parcel.writeValue(maximaEsperanzaVida)
        parcel.writeValue(domesticado)
        parcel.writeString(nombreEspecie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BRaza> {
        override fun createFromParcel(parcel: Parcel): BRaza {
            return BRaza(parcel)
        }

        override fun newArray(size: Int): Array<BRaza?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombreRaza\nNombre cientifico = $nombreCientífico\nAlimentación = $alimentacion\nEsperanza de vida = $maximaEsperanzaVida\nDomesticado = $domesticado"
    }

}