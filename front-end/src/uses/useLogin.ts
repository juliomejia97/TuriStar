import { apiAuthenticate } from "@/services/apiAuthenticate";
import { User } from "@/types/User";
import { ref, Ref } from "vue";

export function useLogin() {
    const user: Ref<User> = ref({email: "", password: "", name: "", lastName: ""});
  
    async function login(){
        await apiAuthenticate.authenticate(user.value)
        localStorage.setItem('logged', "true")
    }

    return { 
        user,
        login };
  }