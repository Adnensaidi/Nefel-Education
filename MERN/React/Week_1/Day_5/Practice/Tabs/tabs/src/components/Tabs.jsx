import React from 'react'

function Tabs() {
    const Tabs = (props) => {
        const { tabsArray, selectTab, tabStyle } = props;
        return (
            <div style={{ margin: "auto", width: "85%", textAlign: "left" }}>
                {
                    tabsArray.map((tab, index) => (
                        <div key={index} 
                        className={`tab ${tabStyle(index)}`} 
                        onClick={(e) => selectTab(index)}>
                            {tab.label}
                        </div>
                    ))
                }
            </div>
        )
    }
    
}

export default Tabs