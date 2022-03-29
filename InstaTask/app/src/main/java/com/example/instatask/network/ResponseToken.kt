package com.example.instatask.network

import com.example.instatask.R
import com.google.gson.annotations.SerializedName

data class ResponseTokenSkill(

    @SerializedName("skills1")
    val list:List<ResponseSkillType>,

    )

data class ResponseTokenReview(
    @SerializedName("review2")
    val list:List<ResponseReviewType>
)


object baseList {

    val list:List<ResponseSkillType> =
        listOf(
            ResponseSkillType(id=1, "Peter", 5, "There are words here", "workinprogress"),
            ResponseSkillType(id=2, "Carlos",10, "Many words","workinprogress"),
            ResponseSkillType(id=3, "Adama",15, "The words must flow","workinprogress"),
            ResponseSkillType(id=4, "Chinchu",20, "On and on it goes","workinprogress"),
            ResponseSkillType(id=5, "Lyle", 25, "This can never end","workinprogress"),
            ResponseSkillType(id=6, "Aidan", 30, "Good bye","workinprogress"),


            )

}

