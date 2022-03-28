import React, {useState} from "react";
import {Box, Button, Drawer, IconButton, Toolbar, Typography} from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';
import AppBar from '@mui/material/AppBar';

export const NavBar = () => {
    const [open, setOpen] = useState(false)

    const setDrawerState = (drawerState: boolean) => {
        console.log(open)
        setOpen(drawerState)
    }

    return(
        <Box>
            <AppBar
                sx={{flexDirection: "row", justifyContent: "space-between", alignItems: "center"}}
                position={"static"}
            >
                <IconButton
                    onClick={() => setDrawerState(!open)}
                    sx={{mr: 4}}
                >
                    <MenuIcon fontSize={"large"}/>
                </IconButton>
                <Typography variant="h6">
                    Api
                </Typography>
                <Button color="inherit">Login</Button>
            </AppBar>
            <Drawer
                open={open}
                onClose={() => setDrawerState(false)}
            />
        </Box>
    )
}
