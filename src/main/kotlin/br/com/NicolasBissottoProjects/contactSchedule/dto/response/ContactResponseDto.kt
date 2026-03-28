package br.com.NicolasBissottoProjects.contactSchedule.dto.response

import java.time.LocalDate

data class ContactResponseDto(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val registeredDate: LocalDate
)
