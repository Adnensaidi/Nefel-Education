const Item = (props) => {


    const { styled, itemText, itemContent, checkboxHandler, buttonHandler, buttonText } = props;


    return (
        <>
            <p className={styled}>{itemText} {itemContent} </p>
            <input type="checkbox" onChange={checkboxHandler} name="checkbox" />
            <button onClick={buttonHandler}>{buttonText}</button>
        </>
    )
}

export default Item;
