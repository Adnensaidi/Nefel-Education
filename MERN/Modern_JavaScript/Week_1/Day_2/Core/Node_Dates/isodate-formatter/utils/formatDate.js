import dayjs from "dayjs";
import relativeTime from 'dayjs/plugin/relativeTime.js';
dayjs.extend(relativeTime);

const formatInput = (date) => dayjs(date).format('MMM D, YYYY h:mm A');

const formatInputToDate = (date) => dayjs(date).format('dddd, MMMM DD, YYYY');

const formatInputToDate2 = (date) => dayjs(date).format('MM/DD/YYYY');

const timeSince = (date) => dayjs(dayjs(date).format('YYYY-MM-DD')).fromNow();

export {formatInput, timeSince, formatInputToDate, formatInputToDate2}