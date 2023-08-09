import { useForm } from "react-hook-form"
import { useApp } from "../../hooks/useApp"

function Login() {
  const { register, handleSubmit } = useForm()
  const { setValue } = useApp()

  const onSubmit = (dataFromForm) => {
    setValue(dataFromForm)
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)} >
      <input type="email" {...register("email")} />
      <input type="password" {...register("password")} />
      <input type="submit" value="Submit" />
    </form>
  )
}

export { Login }