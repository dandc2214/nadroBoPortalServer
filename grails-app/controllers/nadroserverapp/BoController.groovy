package nadroserverapp

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import com.mysecurerest.*

import com.mysecurerest.User

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class BoController {
	static responseFormats = ['json', 'xml']
	
    def openDocUrlGeneratorService

    def index() { }


    def getUri(){
        def user = User.findByUsername(params.username)
        render openDocUrlGeneratorService.openDocumentToken(user.nadroSapId.toString())
    }
}
