package br.com.NicolasBissottoProjects.contactSchedule.repository

import br.com.NicolasBissottoProjects.contactSchedule.model.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository: JpaRepository<Contact, Long> {
}