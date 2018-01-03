package nadroserverapp.management

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import com.mysecurerest.*

@Secured(['ROLE_ADMIN'])
class UserManagementController {
	static responseFormats = ['json']

    def listUser(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]
    }

    def showUser(Long userId) {

        User user = User.get(userId)

        if(user == null) {
            render status:404
        }
        else {
            respond user
        }
    }

    @Transactional
    def saveUser(User user) {
        if(user.hasErrors()) {
            respond user.errors, view:'create' 
        }
        else {
            user.save flush:true
            withFormat {
                html { 
                    flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'user'), user.id])
                    redirect user 
                }
                '*' { render status: CREATED }
            }
        }
    }

    @Transactional
    def updateUser() {

        User user = User.get(params.userId)

        if(user == null) {
            render status: NOT_FOUND
        }
        else {
            if(user.hasErrors()) {
                respond user.errors, view:'edit' 
            }
            else {
                println ("user===========> ${user}")
                bindData(user, request)
                println ("user===========> ${user}")
                user.save flush:true
                withFormat {
                    html { 
                        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'user'), user.id])
                        redirect user 
                    }
                    '*' { render status: OK }
                }
            }
        }
    }

    @Transactional
    def deleteUser(Long userId) {

        User user = User.get(userId)

        if(user == null) {
            render status: NOT_FOUND
        }
        else {
            if(user.hasErrors()) {
                respond user.errors, view:'edit' 
            }
            else {
                user.save flush:true
                withFormat {
                    html { 
                        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'user'), user.id])
                        redirect user 
                    }
                    '*' { render status: OK }
                }
            }
        }
    }
	
    // If time implement command and viewFormater for this stuff
    /* def list() {

        respond User.list()        

    }

    def showUser(Long userId){
        def user =  User.get(userId)

        if(!user){
            render status:404
        }

        respond user
    }

    def saveUser(){

        User user = new User()
        bindData(user, request)

        println user as grails.converters.JSON

        if(user.hasErrors()){
            respond user.errors, view:'create' 
        }else{
            user.save flush: true
            def role = new Authority(authority:"ROLE_USER").save()
            UserAuthority.create(user,role)

            respond user
        }
    }

    def updateUser(Long userId){

        def user =  User.get(userId)

        if(!user){
            render status: 404
        }else{
            bindData(user, request)
            if(user.hasErrors()){
                respond user.errors, view:'edit' 
            }else{
                user.save flush: true
                respond user
            }            
        }
    }

    def deleteUser(Long userId){
        def user = User.get(userId)

         if(!user){
            render status: 404
        }else{
            def res = user.delete(failOnError: true)
            render status: 200
        }        
    }
 */
}
