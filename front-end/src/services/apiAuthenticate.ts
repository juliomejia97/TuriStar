import { login_path } from "@/config/urls";
import { User } from "@/types/User";


export const apiAuthenticate = {

    authenticate(user: User) {
        const url = process.env.VUE_APP_BASE_URL.concat(login_path)
        const config = {
            method: "POST",
            headers: {
                "mode": "no-cors",
                "Content-type": "application/json"
            },
            body: JSON.stringify({ email: user.email, password: user.password })
        }
        return fetch(url, config)
            .then((response) => {
                alert(response)
                if (!response.ok) {
                    alert(response.status)
                } else {
                    alert("Autenticado" + localStorage.logged)
                }
            })
            .catch((error) => {
                console.log(error)
                throw error
            });
    }
}