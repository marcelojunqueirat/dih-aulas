function AdviceCard(props) {
  return (
    <div>
      {props.list.map((item, key) => (
        <p key={key}>{`${key + 1} - ${item}`}</p>
      ))}
    </div>
  )
}

export { AdviceCard }