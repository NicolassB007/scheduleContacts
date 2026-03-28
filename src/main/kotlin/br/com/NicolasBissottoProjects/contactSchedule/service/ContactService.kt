package br.com.NicolasBissottoProjects.contactSchedule.service

import br.com.NicolasBissottoProjects.contactSchedule.dto.request.ContactRequestDto
import br.com.NicolasBissottoProjects.contactSchedule.dto.response.ContactResponseDto
import br.com.NicolasBissottoProjects.contactSchedule.model.Contact
import br.com.NicolasBissottoProjects.contactSchedule.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactService(
    private val contactRepository: ContactRepository
) {
    // Regex contendo o padrão para telefone
    private val phoneRegex = Regex("""^\(?\d{2}\)?\s?\d{4,5}-\d{4}$""")
    private val emailRegex = Regex("""^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$""")

    fun registerContact(request: ContactRequestDto): ContactResponseDto {
        // Validando o telefone antes de salvar
        require(phoneRegex.matches(request.phone)) {
            "Telefone inválido: '${request.phone}'. Use o formato (14) 12345-6789"
        }

        require(emailRegex.matches(request.email)) {
            "Email inválido: '${request.email}'. Use o formato meuemail@dominio.com"
        }

        val contact = Contact(
            name = request.name,
            phone = request.phone,
            email = request.email
        )

        contactRepository.save<Contact>(contact)

        return contact.toResponse()
    }

    fun getAllContacts(): List<ContactResponseDto> {
        return contactRepository.findAll().map { contact -> ContactResponseDto(
            contact.id,
            contact.name,
            contact.email,
            contact.phone,
            contact.registerDate
        ) }
    }

    /*
    * Extension function para conversão de Contact para ContactRequestDto
    * O retorno é uma instância de ContactResponseDto
    * */
    private fun Contact.toResponse(): ContactResponseDto {
        return ContactResponseDto(
            id = id,
            name = name,
            email = email,
            phone = phone,
            registeredDate = registerDate
        )
    }
}