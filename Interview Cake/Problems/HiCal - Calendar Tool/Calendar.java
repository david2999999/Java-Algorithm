public class Calendar {
    public List<Meeting> mergeCalendar(List<Meeting> meetings) {
        if (meetings == null || meetings.isEmpty()) {
            return new ArrayList<>();
        }

        List<Meeting> sortedMeetings = new ArrayList<>();
        for (Meeting meeting: meetings) {
            Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
            sortedMeetings.add(meeting);
        }

        Collections.sort(sortedMeetings, new MeetingComparator<>());

        List<Meeting> mergedList = new ArrayList<>();
        mergedList.add(sortedMeetings.get(0));

        for (Meeting currentMeeting: sortedMeetings) {
            Meeting lastMergeMeeting = mergedList.get(mergedList.size() - 1);

            if (lastMergeMeeting.getEndTime() <= currentMeeting.getStartTime()) {
                lastMergeMeeting.setEndTime(Math.abs(lastMergeMeeting.getEndTime(), currentMeeting.getEndTime()));
            } else {
                mergedList.add(currentMeeting);
            }
        }

        return mergedList;
    }

    private static class MeetingComparator<Meeting> {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            return m1.getStartTime() - m2.getStartTime();
        }
    }
}