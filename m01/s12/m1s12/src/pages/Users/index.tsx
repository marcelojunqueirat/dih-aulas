import { useState, useEffect } from "react"
import { api } from "../../services/api"
import { UsersProps } from "./interfaces"
import { PageUsersMain } from './styled'

function Users() {
  const [users, setUsers] = useState<UsersProps[]>([])
  const [loading, setLoading] = useState(false)

  const load = async () => {
    setLoading(true)
    const response = await api.get('/users')
    setUsers(response.data);
    setLoading(false)
  }

  useEffect(() => {
    load()
  }, [])

  if(loading){
    return (
      <p>Carregando ...</p>
    )
  }

  return (
    <PageUsersMain>
      {
        users.length > 0 ? users.map((item) => (
          <div key={item.id}>
            <p>Id: {item.id}</p>
            <p>Nome: {item.name}</p>
            <p>Email: {item.email}</p>
          </div>
        ))
        :
        <p>Não há usuários cadastrados</p>
      }
    </PageUsersMain>
  )
}

export { Users }