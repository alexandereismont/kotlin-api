import React, {FC, useCallback, useEffect} from 'react';
import {DataGrid, GridColDef, GridDensityTypes} from '@mui/x-data-grid';

const columns: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70, flex: 1 },
    { field: 'name', headerName: 'Name', width: 130, flex: 1 },
    {
        field: 'rating',
        headerName: 'Rating',
        type: 'number',
        width: 90,
        flex: 1,
    },
    {
        field: 'company',
        headerName: 'Company',
  //      description: 'This column has a value getter and is not sortable.',
   //     sortable: false,
        width: 160,
        flex: 1,
    },
    {
        field: "createdAt",
        headerName: "Created at",
        flex: 1,
    },
    {
        field: "updatedAt",
        headerName: "Updated at",
        flex: 1,
    }
];

export const SuperheroTable: FC<{data: any[], search: string}> = ({data, search}) => {

    const filterSearch = useCallback(() => {
        const filteredRows = data.filter((row) => {
            return row.name.toLowerCase().includes(search.toLowerCase());
        });
        return filteredRows
    }, [data, search])

    return (
        <div>
            <DataGrid
                density={GridDensityTypes.Standard}
                autoHeight
                pageSize={5}
                rowsPerPageOptions={[5]}
                columns={columns}
                rows={filterSearch()}
                checkboxSelection
                showColumnRightBorder={false}
            />
        </div>
    )
}
