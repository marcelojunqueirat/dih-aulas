import {createContext, useState} from 'react'

export const CounterContext = createContext()

export const CounterContextProvider = (props) => {
  const [count, setCount] =  useState(0)
  const [count2, setCount2] =  useState(1000)

  return (
    <CounterContext.Provider value={{count, setCount, count2, setCount2}}>
      {props.children}
    </CounterContext.Provider>
  )
}

