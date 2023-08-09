import { Routes, Route } from 'react-router-dom'
import { Users } from '../pages/Users'

function PrivateRoutes() {
  return (
    <Routes>
      <Route path='/' element={<Users />} />
    </Routes>
  )
}

export { PrivateRoutes }