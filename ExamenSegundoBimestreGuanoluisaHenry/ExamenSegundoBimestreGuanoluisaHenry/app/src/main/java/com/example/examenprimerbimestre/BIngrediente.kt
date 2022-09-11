package com.example.examenprimerbimestre
import android.os.Parcel
import android.os.Parcelable

class BIngrediente(
    var ingrediente1: String?,
    var ingrediente2: String?,
    var ingrediente3: String?,
    var ingrediente4: String?,
    var ingrediente5: String?,
    var nombrePlato: String?
    ): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ingrediente1)
        parcel.writeString(ingrediente2)
        parcel.writeString(ingrediente3)
        parcel.writeString(ingrediente4)
        parcel.writeString(ingrediente5)
        parcel.writeString(nombrePlato)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BIngrediente> {
        override fun createFromParcel(parcel: Parcel): BIngrediente {
            return BIngrediente(parcel)
        }

        override fun newArray(size: Int): Array<BIngrediente?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombrePlato\n\nIngrediente 1 : $ingrediente1\nIngrediente 2 : $ingrediente2\nIngrediente 3 : $ingrediente3\n" +
                "Ingrediente 4 : $ingrediente4\nIngrediente 5 : $ingrediente5"
    }

}