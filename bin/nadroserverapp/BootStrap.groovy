package nadroserverapp

import com.mysecurerest.User
import com.mysecurerest.Authority
import com.mysecurerest.UserAuthority

class BootStrap {

    def init = { servletContext ->

        def role1 = new Authority(authority:"ROLE_ADMIN").save()
        def user1 = new User(username:"admin",password:"sineti.1", nadroSapId:1, name:"Daniel", lastname:"Delgadillo").save()
        def role2 = new Authority(authority:"ROLE_USER").save()
        def user2 = new User(username:"user",password:"password", nadroSapId:2, name:"Ber", lastname:"Delgadillo").save()

        // if(!user1.save()){
        //     user1.errors.allErrors.each { println it }
        // }
        
        UserAuthority.create(user1,role1)
        UserAuthority.create(user2,role2)

    }
    def destroy = {
    }
}
