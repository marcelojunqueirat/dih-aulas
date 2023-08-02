import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { Home } from '../pages/home'
import { NotFound } from '../pages/404'
import { AboutMe } from '../pages/AboutMe'
import { Portfolio } from '../pages/Portfolio'

function RoutesApp() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="*" element={<NotFound />} />
        <Route path="/" element={<Home />} />
        <Route path="/aboutme" element={<AboutMe />} />
        <Route path="/portfolio" element={<Portfolio />} />
      </Routes>
    </BrowserRouter>
  )
}

export { RoutesApp }