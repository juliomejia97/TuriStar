import { login_path } from "@/config/urls";
import { User } from "@/types/User";

export const apiAuthenticate = {

    authenticate(user: User) {
        const url = process.env.VUE_APP_BASE_URL.concat(login_path)
        const config = {
            method: "POST",
            header: {mode: "no-cors"},
            body: JSON.stringify(user)
        }
        return fetch(url, config)
            .then( (response) => {
                alert(response)
                if(!response.ok) {
                    alert(response.status)
                }else{
                    alert("Autenticado")
                }
            })
            .catch((error) => {
                console.log(error)
                throw error
            });
        }
}