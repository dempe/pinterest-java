package com.chrisdempewolf.pinterest.responses.user

import com.google.gson.annotations.SerializedName
import com.chrisdempewolf.pinterest.responses.SixtyBySixty

data class Image(@SerializedName("60x60") val sixtyBySixty: SixtyBySixty?)