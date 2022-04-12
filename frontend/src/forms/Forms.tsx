import React, {Dispatch, FC, SetStateAction} from 'react'
import {TextField} from "@mui/material";
import styles from './forms.module.scss';

export const Forms: FC<{setSearch: Dispatch<SetStateAction<string>>}> = ({setSearch}) => {
    return(
        <form className={styles.search}>
            <TextField
                id="outlined-search"
                label="Search"
                type="search"
                size={"small"}
                onChange={(e) => setSearch(e.target.value)}
            />
        </form>
    )
}
