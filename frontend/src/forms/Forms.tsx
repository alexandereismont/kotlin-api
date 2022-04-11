import React from 'react'
import {TextField} from "@mui/material";
import styles from './forms.module.scss';

export const Forms = () => {
    return(
        <form className={styles.search}>
            <TextField id="outlined-search" label="Søk" type="search" size={"small"}/>
        </form>
    )
}
