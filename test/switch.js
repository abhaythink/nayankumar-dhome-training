let month = 2;
let monthName;

switch (month) {
    case 1:  monthName = "Jan"; break;
    case 2:  monthName = "Feb"; break;
    case 3:  monthName = "Mar"; break;
    case 4:  monthName = "Apr"; break;
    case 5:  monthName = "May"; break;
    case 6:  monthName = "Jun"; break;
    case 7:  monthName = "Jul"; break;
    case 8:  monthName = "Aug"; break;
    case 9:  monthName = "Sup"; break;
    case 10: monthName = "Oct"; break;
    case 11: monthName = "Nov"; break;
    case 12: monthName = "Dec"; break;
    default: monthName = "Invalid";
}

if (monthName === "Invalid") {
    console.log("Invalid month number");
} else {
    console.log("Month is:", monthName);
}
