package com.example.demo.enumValObj

import java.util.*

/**
 * 状態遷移の管理
 */
class PlanTransitions {
    private val allowed = mutableMapOf<PlanState, EnumSet<PlanState>>()

    init {
        this.allowed[PlanState.BEFORE_RESERVE] = EnumSet.of(PlanState.RESERVED)
        this.allowed[PlanState.RESERVED] = EnumSet.of(PlanState.CHECKED_IN, PlanState.CANCEL_RESERVE)
        this.allowed[PlanState.CANCEL_RESERVE] = EnumSet.of(PlanState.BEFORE_RESERVE)
        this.allowed[PlanState.CHECKED_IN] = EnumSet.of(PlanState.CANCEL_CHECK_IN, PlanState.CHECKED_OUT)
        this.allowed[PlanState.CANCEL_CHECK_IN] = EnumSet.of(PlanState.RESERVED, PlanState.CANCEL_RESERVE)
        this.allowed.toMap()
    }

    fun canTransit(from: PlanState, to: PlanState) : Boolean {
        val allowedStates = this.allowed[from]
        return allowedStates?.contains(to) ?: false
    }
}

enum class PlanState {
    BEFORE_RESERVE,
    RESERVED,
    CANCEL_RESERVE,
    CHECKED_IN,
    CANCEL_CHECK_IN,
    CHECKED_OUT,
}