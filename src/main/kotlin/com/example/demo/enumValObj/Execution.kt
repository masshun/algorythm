package com.example.demo.enumValObj

class Execution {
    fun main() {
        var planType = "MEETING"
        val meetingRate = PlanType.valueOf(planType).calcReservedRate(count = 10)
        println(meetingRate)

        planType = "RELAX"
        val relaxRoomRelax = PlanType.valueOf(planType).calcReservedRate(count = 4)
        println(relaxRoomRelax)

        val canTransit = PlanTransitions().canTransit(PlanState.RESERVED, PlanState.CANCEL_RESERVE)
        println(canTransit)
    }
}