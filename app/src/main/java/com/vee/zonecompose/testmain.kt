package com.vee.zonecompose

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.Base64


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
//    val alias = "alias"
//    val uid = "username"
//    val password = "password"
//    println("Uid: $uid\npassword:$password\n")
//    val uidEnc = CryptoManager().encrypt(alias.toByteArray(),uid).toString()
//    val passEnc = EnCryptor().encryptText(alias,password).toString()
//    println("uidEnc: $uidEnc\npassEnc:$passEnc\n")
//

//    val message =
//        "\"baseUrl\":\"\",\"buildType\":\"\",\"exchange\":\"\",\"rbBuildType\":\"\",\"rbHost\":\"\",\"rbPassword\":\"\",\"rbUserName\":\"\",\"rbVirtualHost\":\"\",\"routingKey\":\"\",\"site\":\"\"}"
//    println("$message")
//    val encodedMessage = Encode.encode(message)
//    println("encodedMessage$encodedMessage")
//    val decodeMessage = Decode.decode(encodedMessage)
//    println("decodeMessage$decodeMessage")


    val key = 8 // Shift value for Caesar cipher
    val plainText = "Hello, World!  // Encrypt the plain text\n" +
            "//    val encryptedText = encrypt(plainText, key)"
    println("plainText : $plainText")

    // Encrypt the plain text
//    val encryptedText = encrypt(plainText, key)
    val encryptedText: String = Base64.getEncoder().encodeToString(plainText.toByteArray())
    println("Encrypted Text: $encryptedText")

    // Decrypt the encrypted text
//    val decryptedText = decryptTxt(encryptedText, key)
    val decryptedText: String = String(Base64.getDecoder().decode(encryptedText))
    println("Decrypted Text: $decryptedText")

}

fun encrypt(plainText: String, key: Int): String {
    return plainText.map { char ->
        if (char.isLetter()) {
            char.code + key
        } else {
            char.code + key
        }
    }.joinToString("")
}


fun decryptTxt(plainText: String, key: Int): String {
    return plainText.map { char ->
        if (char.isLetter()) {
           ( char.code - key).toChar()
        } else {
            (char.code - key).toChar()
        }
    }.joinToString("")
}

fun decrypt(encryptedText: String, key: Int): String {
    return encrypt(encryptedText, -key)
}


object Decode {
    fun decode(s: String): String {
        val invalid = "Invalid Code"

        // create the same initial
        // string as in encode class
        val ini = "11111111"
        var flag = true

        // run a loop of size 8
        for (i in 0..7) {
            // check if the initial value is same
            if (ini[i] != s[i]) {
                flag = false
                break
            }
        }
        var `val` = ""

        // reverse the encrypted code
        for (i in 8 until s.length) {
            val ch = s[i]
            `val` = `val` + ch.toString()
        }

        // create a 2 dimensional array
        val arr = Array(s.length) { IntArray(8) }
        var ind1 = -1
        var ind2 = 0

        // run a loop of size of the encrypted code
        for (i in 0 until `val`.length) {

            // check if the position of the
            // string if divisible by 7
            if (i % 7 == 0) {
                // start the value in other
                // column of the 2D array
                ind1++
                ind2 = 0
                val ch = `val`[i]
                arr[ind1][ind2] = ch.code - '0'.code
                ind2++
            } else {
                // otherwise store the value
                // in the same column
                val ch = `val`[i]
                arr[ind1][ind2] = ch.code - '0'.code
                ind2++
            }
        }
        // create an array
        val num = IntArray(s.length)
        var nind = 0
        var tem = 0
        var cu = 0

        // run a loop of size of the column
        for (i in 0..ind1) {
            cu = 0
            tem = 0
            // convert binary to decimal and add them
            // from each column and store in the array
            for (j in 6 downTo 0) {
                val tem1 = Math.pow(2.0, cu.toDouble()).toInt()
                tem += arr[i][j] * tem1
                cu++
            }
            num[nind++] = tem
        }
        var ret = ""
        var ch: Char
        // convert the decimal ascii number to its
        // char value and add them to form a decrypted
        // string using conception function
        for (i in 0 until nind) {
            ch = num[i].toChar()
            ret = ret + ch.toString()
        }
        Log.e("dec", "text 11 - $ret")

        // check if the encrypted code was
        // generated for this algorithm
        return if (`val`.length % 7 == 0 && flag == true) {
            // return the decrypted code
            ret
        } else {
            // otherwise return an invalid message
            invalid
        }
    }
}


object Encode {
    fun encode(s: String): String {
        val ini = "11111111"
        var cu = 0

        // create an array
        val arr = IntArray(s.length)
        // iterate through the string
        for (i in 0 until s.length) {
            arr[i] = s[i].code
            cu++
        }

        var res = ""
        val bin = IntArray(s.length)
        var idx = 0

        // run a loop of the size of string
        for (i1 in 0 until cu) {

            // get the ascii value at position
            // i1 from the first array
            var temp = arr[i1]

            // run the second nested loop of same size
            // and set 0 value in the second array
            for (j in 0 until cu) bin[j] = 0
            idx = 0

            // run a while for temp > 0
            while (temp > 0) {
                // store the temp module
                // of 2 in the 2nd array
                bin[idx++] = temp % 2
                temp = temp / 2
            }
            var dig = ""
            var temps: String

            // run a loop of size 7
            for (j in 0..6) {

                // convert the integer to string
                temps = Integer.toString(bin[j])

                // add the string using
                // concatenation function
                dig = dig + temps
            }
            var revs = ""

            // reverse the string
            for (j in dig.length - 1 downTo 0) {
                val ca = dig[j]
                revs = revs + ca.toString()
            }
            res = res + revs
        }
        // add the extra string to the binary code
        res = ini + res

        // return the encrypted code
        return res
    }
}