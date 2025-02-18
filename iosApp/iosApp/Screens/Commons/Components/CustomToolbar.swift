import SwiftUI

struct CustomToolbar: View {
    let title: String
    var backAction: () -> Void
    var saveAction: () -> Void
    @State var isSaved: Bool
    var icon: String {
        isSaved ? "heart.fill" : "heart"
    }
    var body: some View {
        HStack {
            Button(action: backAction) {
                Image(systemName: "chevron.left")
                    .font(.title2)
                    .foregroundColor(.white)
            }
            Spacer()
            Text(title)
                .font(.headline)
                .foregroundColor(.primary)

            Spacer()
            Button(action: saveAction) {
                Image(systemName: icon)
                    .font(.title2)
                    .foregroundColor(.white)
            }
        }
        .frame(maxWidth: .infinity)
        .padding()
    }
}
