package nadroserverapp

class UrlMappings {

    static mappings = {

        "/api/management/user"(controller: 'userManagement', action:'listUser', method:'GET')
        "/api/management/user/$userId"(controller: 'userManagement', action:'showUser', method:'GET')
        "/api/management/user"(controller: 'userManagement', action:'saveUser', method:'POST')
        "/api/management/user/$userId"(controller: 'userManagement', action:'updateUser', method:'PUT')
        "/api/management/user/$userId"(controller: 'userManagement', action:'deleteUser', method:'DELETE')

        "/api/bo"(controller: 'Bo', action:'getUri', method:'GET')

        /* delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch") */

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
