import { useEffect, useState } from 'react'
import './App.css'
import Card from './components/Card'
import { dataCrypto } from './database/data'

function App() {
  const [list, setList] = useState([]);

  useEffect(() => {
    setList(dataCrypto);
  }, [dataCrypto]);

  return (
    <>
      <Card list={list} />
    </>
  )
}

export default App;
