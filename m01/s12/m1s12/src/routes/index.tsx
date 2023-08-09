import { Routes, Route } from 'react-router-dom'
import { PrivateRoutes } from "./privateRoutes"
import { PublicRoutes } from "./publicRoutes"
import { useApp } from "../hooks/useApp"

function RoutesApp() {
  const { value } = useApp()

  if(value?.email){
    return (
      <PrivateRoutes />
    )
  }
  return (
    <PublicRoutes />
  )
}

export { RoutesApp }