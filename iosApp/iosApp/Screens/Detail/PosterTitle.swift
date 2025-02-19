
import SwiftUI

struct PosterTitle: View {
    var title: String
    var imageName: String
    
    var body: some View {
        HStack {
            AsyncImage(url: URL(string: imageName)) { image in
                if image.image != nil {
                    image.image!
                        .resizable()
                        .scaledToFill()
                        .frame(width: 135)
                        .cornerRadius(15)
                } else if image.error != nil {
                    Text("Image Load Error")
                } else {
//                    ProgressView()
                }
            }
            VStack {
                    Spacer()
                    Text(title)
                    .font(.title3)
                        .padding(.bottom)
            }
            .frame(maxHeight: .infinity)
            Spacer()
        }
        .padding()
    }
}

//#Preview {
//    PosterTitle()
//}
