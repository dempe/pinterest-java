package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

class BoardResponse(@SerializedName("data") val board: Board?)
