import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { Home } from '../pages/Home'
import { NotFound } from '../pages/NotFound'
import { AboutMe } from '../pages/AboutMe'
import { Portfolio } from '../pages/Portfolio'

function RoutesApp() {
  return (
    <BrowserRouter>
      <Routes>
        {/* <Route path="*" element={<NotFound />} /> */}
        <Route path="*" element={<Navigate to="/" replace />} />
        <Route path="/" element={<Home />} />
        <Route path="/aboutme" element={<AboutMe />} />
        <Route path="/portfolio/:username" element={<Portfolio />} />
      </Routes>
    </BrowserRouter>
  )
}

export { RoutesApp }