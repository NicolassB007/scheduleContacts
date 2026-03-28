package br.com.NicolasBissottoProjects.contactSchedule.controller

import br.com.NicolasBissottoProjects.contactSchedule.dto.request.ContactRequestDto
import br.com.NicolasBissottoProjects.contactSchedule.dto.response.ContactResponseDto
import br.com.NicolasBissottoProjects.contactSchedule.model.Contact
import br.com.NicolasBissottoProjects.contactSchedule.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ContactController(
    private val contactService: ContactService
) {

    @GetMapping("/contacts")
    fun getContacts(): ResponseEntity<List<Contact>> {
        return ResponseEntity.ok(contactService.getAllContacts())
    }

    @PostMapping("/register")
    fun registerContact(
        @RequestBody contactRequestDto: ContactRequestDto
    ): ResponseEntity<ContactResponseDto> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(contactService.registerContact(contactRequestDto))
    }
}